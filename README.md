# MicroProfile generated Application

## Introduction

MicroProfile Starter has generated this MicroProfile application for you.

The generation of the executable jar file can be performed by issuing the following command

    mvn clean package

This will create an executable jar file **localization-svc.jar** within the _target_ maven folder. This can be started by executing the following command

    java -jar target/localization-svc.jar


### Liberty Dev Mode

During development, you can use Liberty's development mode (dev mode) to code while observing and testing your changes on the fly.
With the dev mode, you can code along and watch the change reflected in the running server right away; 
unit and integration tests are run on pressing Enter in the command terminal; you can attach a debugger to the running server at any time to step through your code.

    mvn liberty:dev



To launch the test page, open your browser at the following URL

    http://localhost:9080/index.html

## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.

Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.

More information on MicroProfile can be found [here](https://microprofile.io/)








### Metrics

The Metrics exports _Telemetric_ data in a uniform way of system and custom resources. Specification [here](https://microprofile.io/project/eclipse/microprofile-metrics)

The example class **MetricController** contains an example how you can measure the execution time of a request.  The index page also contains a link to the metric page (with all metric info)





### Open API

Exposes the information about your endpoints in the format of the OpenAPI v3 specification. Specification [here](https://microprofile.io/project/eclipse/microprofile-open-api)

The index page contains a link to the OpenAPI information of your endpoints.




### Open Tracing

Allow the participation in distributed tracing of your requests through various micro services. Specification [here](https://microprofile.io/project/eclipse/microprofile-opentracing)

To show this capability, you need to download [Jaeger](https://www.jaegertracing.io/download/#binaries) and run ```./jaeger-all-in-one```. 
Alternatively, you can dowanload the docker image of `all-in-one` using ```docker pull jaegertracing/all-in-one:${version}```,
followed by running the docker image. Refer to [Jaeger doc](https://www.jaegertracing.io/docs/) for more info.

Open [http://localhost:16686/](http://localhost:16686/) to see the traces. You have to invoke your demo app endpoint for any traces to show on Jaeger UI.



