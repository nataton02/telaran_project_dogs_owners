# telaran_project_dogs_owners
Dog & Dog Owner

Create API 

**/owners**                POST - create

**/owners/{id}**           GET - Get owner data

owner fields:

- id
- firstName
- lastName
- dateOfBirth

**/owners/{id}/dogs/{dog_id}*** PUT
** dog toggle

```java
{
  "owner": ...,
  "dogs": [
    {
      "id": ...,
      "nickname": "Spot",
      "registrationDate": "2022-01-01"
    }
  ]
}
```

**/dogs/unregistered*** - GET

find all not registered dogs

**/dogs** - POST 

create a dog with fields:

- id
- nickname
- breed
- dateOfBirth
- owner - null by default
- registrationDate - is assigned, when owner is assigned with the dog
