package com.zaynsolutions.config;
import com.google.cloud.opentelemetry.trace.TraceConfiguration;
import com.google.cloud.opentelemetry.trace.TraceExporter;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class TraceExporterApp {
  //In Power shell run these commands
  //$env:GOOGLE_CLOUD_PROJECT="applied-summer-374415"                                                                              
  // $env:GOOGLE_APPLICATION_CREDENTIALS="\\wsl.localhost\Ubuntu-22.04\home\adeel\.config\gcloud\application_default_credentials.json"  
  //cd '\\wsl.localhost\Ubuntu-22.04\home\adeel\configwebapp'; & 'C:\Users\adeel\jdk-11\bin\java.exe' '@C:\Users\adeel\AppData\Local\Temp\cp_4w8dcexbh1sd2yfhvd18hoqn3.argfile' 'com.zaynsolutions.config.TraceExporterApp'
  private static final Random random = new Random();

  public static void main(String[] args) {
    // Using default project ID and Credentials
    TraceConfiguration configuration =
        TraceConfiguration.builder().setDeadline(Duration.ofMillis(30000)).build();

    try {
      TraceExporter traceExporter = TraceExporter.createWithConfiguration(configuration);
      // Register the TraceExporter with OpenTelemetry
        OpenTelemetrySdk otel = OpenTelemetrySdk.builder()
        .setTracerProvider(
            SdkTracerProvider.builder()
                .addSpanProcessor(
                    SimpleSpanProcessor.create(TraceExporter.createWithConfiguration(configuration))
                )
                .build()
        )
        .buildAndRegisterGlobal();

      Tracer tracer = otel.getTracer("0d0a16152ab685e2ced89e5948184476");
      // Application-specific logic
      createSpan("/firstUrl",tracer);
      createSpan("/secondUrl",tracer);
      otel.getSdkTracerProvider().shutdown();
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Uncaught Exception");
    }

    // Flush all buffered traces
  }

  private static void createSpan(String description,Tracer tracer) {
    // Generate a span
    Span span = tracer.spanBuilder(description).startSpan();
    try (Scope scope = span.makeCurrent()) {
      span.addEvent("Event A");
      span.setAttribute("opentelemetry", "https://opentelemetry.io/");
      // Do some work for the use case
      for (int i = 0; i < 3; i++) {
        String work = String.format("%s - Work #%d", description, (i + 1));
        // Child span
        Span span1 = tracer.spanBuilder(work).startSpan();
        try (Scope scope1 = span1.makeCurrent()) {
          // Simulate work: this could be simulating a network request or an expensive disk operation
          Thread.sleep(100 + random.nextInt(5) * 100);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        } finally {
          span1.end();
        }
      }
      span.addEvent("Event B");
    } finally {
      span.end();
    }
  }
}