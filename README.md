## Gradle commands

All commands should be executed inside the :bundle project.

That is:

```bash
$ ./gradlew :bundle:runClient
# or
$ ./gradlew :bundle:build
```

This will ensure that all the projects are loaded correctly.

The bundle jar can be found in `bundle/build/libs` directory.

For `genSources`, you should also do that:

```bash
$ ./gradlew :bundle:genSources
```
