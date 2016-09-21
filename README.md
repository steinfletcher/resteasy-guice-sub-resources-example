Resteasy, Guice and Sub Resources
===

- Jetty embedded 9.x
- Resteasy 3.x (JAX-RS 2.0)
- Guice 4.0

## Info

Sub resources allow partial request processing and another "sub" resource to process the remainder
of the request

```
/genre/{name}/movies
```

First the `genre` resource is resolved, the handler for this method returns then `movies` subresource is
invoked at runtime (dynamic dispatch).

see https://access.redhat.com/documentation/en-US/JBoss_Enterprise_Web_Platform/5/html/RESTEasy_Reference_Guide/JAX-RS_Resource_Locators_and_Sub_Resources.html

## Example

The `GenreResource` is the parent resource and contains `MoviesResource` as the subresource.
Calling `/genre/{genre name}/movies/{movie id}` will invoke the parent resource then dynamic dispatch to the subresource
at runtime.

The tests also demostrate this working with a dynamic client and hardcoded urls.
The subresource is injected with its dependencies using Guice's `@Assisted` inject.