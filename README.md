# YAML for Pact

You can now write [pact.io](https://pact.io/) contracts in YAML format.

YAML description should also contain the versions of client and producer, so that it can be automatically uploaded with correct tags.

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
