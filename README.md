To run: `gradle run`

The application comes with a couple of test records, so you can start off with a GET:

GET: [http://localhost:8080/person](http://localhost:8080/person)


To add more records:

POST: http://localhost:8080/person

```
{
  "firstName": "Ann",
  "lastName": "Becker",
  "contactInfo": {
    "address": "123 Broadway",
    "email": "ann@example.com"
  }
}
```
