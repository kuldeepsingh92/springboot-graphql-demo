package com.demo.graphql.records;

import java.util.List;

public record MovieRecord(
        String title,
        String director,
        int releaseYear,
        List<String> movieCast) {
}
