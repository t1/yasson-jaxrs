# Yasson JAX-RS

[Yasson](https://github.com/eclipse/yasson) is the reference implementation of [JSON-B](http://json-b.net),
the new standardized API for binding Java to JSON, i.e. to serialize/deserialize Java objects to/from JSON.

This minimalistic library allows you to use the new annotations in your CDI based application,
even before you have a Java EE 8 container,
by providing a JAX-RS `MessageBodyReader` and `MessageBodyWriter` for `application/json`.

Simply add this to your pom.xml:

```xml
<dependencies>
    <dependency>
        <groupId>javax.json.bind</groupId>
        <artifactId>javax.json.bind-api</artifactId>
        <version>1.0.0-M2</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>com.github.t1</groupId>
        <artifactId>yasson-jaxrs</artifactId>
        <version>1.0.0-SNAPSHOT</version>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

<small>Note that the home page of JAX-RS used to be on `java.net`, but that site was shut down.
Jerseys new home is https://jersey.github.io, but I didn't find the JAX-RS spec there, yet.</small>

## Configuration

You can configure JSON-B by CDI-producing an instance of `JsonbConfig`, e.g.:

`@Produces JsonbConfig config = new JsonbConfig().withFormatting(true);`

`JsonbAdapter`s, `JsonbSerializer`, and `JsonbDeserializer`s are automatically discovered (via CDI) and registered.
