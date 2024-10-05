# GraphQl Demo [ SpringBoot + Mysql(CRUD) + ExceptionHandling ]


## GraphQl Shell:
http://localhost:8080/graphql-demo/graphiql


## Get all records
```
{
    getAllMoviesHandler {
        id,
        title,
        director,
        releaseYear,
        movieCast
    }
}
```



## Add a record
```
mutation {
    addMovieHandler(
        movieInput: {
        title: "Bad Boys: Ride or Die"
        director: "Adil & Bilall"
        releaseYear: 2024
        movieCast: [
            "Will Smith"
            "Martin Lawrence"
        ]
    }) {
        id
    }
}
```



## Update a record
```
mutation {
    updateMovieHandler(
        id: 3,
        movieInput: {
        title: "Bad Boys: Ride or Die"
        director: "Adil & Bilall"
        releaseYear: 2023
        movieCast: [
            "Will Smith"
            "Martin Lawrence"
        ]
    }) {
        id
    }
}
```


## Delete a record
```
mutation {
    deleteMovieHandler(id: 3)
}
```
