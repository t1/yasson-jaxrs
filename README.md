# Yasson JAX-RS

[Yasson](https://github.com/eclipse/yasson) is the reference implementation of [JAX-B](http://json-b.net),
the new standardized API for binding Java to JSON, i.e. to serialize/deserialize Java objects to/from JSON.

This minimalistic library allows you to use the new annotations in your app, even before you have a Java EE 8 container,
by providing a JAX-RS `MessageBodyReader` and `MessageBodyWriter` for `application/json`.

Note that the home page of JAX-RS used to be on `java.net`, but that site was shut down.
Jerseys new home is https://jersey.github.io, but I didn't find the JAX-RS spec there, yet.
