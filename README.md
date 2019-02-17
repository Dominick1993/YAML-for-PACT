[![Build Status](https://travis-ci.org/Dominick1993/YAML-for-Pact.svg?branch=master)](https://travis-ci.org/Dominick1993/YAML-for-Pact)

# YAML for Pact

You can now write [pact.io](https://pact.io/) contracts in YAML format.

YAML description should also contain the versions of client and producer, so that it can be automatically uploaded with correct tags.

## How to use

The converter provides a simple CLI with following usage:
```
usage: YAML for Pact
 -d,--destination <destinationDirectory>   Destination directory for
                                           converted files
 -h,--help                                 Prints help
 -r,--recursive                            Use for recursive traversal of
                                           source directory
 -s,--source <sourceDirectory>             Source directory containing
                                           YAML Pact files
```


## How to build

Just execute this job, and you will get an executable JAR in the build directory
```bash
./gradlew clean build
```

## Supported YAML example

```yaml
provider:
  name: server
consumer:
  name: client
interactions:
  - description: random endpoint returns some object with message and id
    request:
      method: GET
      path: /random
      headers:
        Accept: "application/json;charset=UTF-8"
    response:
      status: 200
      headers:
        Content-Type: "application/json;charset=UTF-8"
        Access-Control-Allow-Origin: "*"
      body: '{
               "id": 1234567890,
               "message": {
                 "text": "Extremely random text"
               }
             }'
      matchingRules:
        body:
          "$.id":
            matchers:
              - match: type
          "$.message":
            matchers:
              - match: type
          "$.message.text":
            matchers:
              - match: type
metadata:
  pactSpecification:
    version: "3.0.0"

```
