/*
 *      Copyright (c) 2013-2014 Stuart Boston
 *
 *      This file is part of the OMDB API.
 *
 *      The OMDB API is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      The OMDB API is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with the OMDB API.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.omertron.omdbapi.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omertron.omdbapi.model.AbstractJsonMapping;
import com.omertron.omdbapi.model.OmdbVideoBasic;
import java.util.List;

public class WrapperSearch extends AbstractJsonMapping {

    @JsonProperty("Search")
    private List<OmdbVideoBasic> results;

    public List<OmdbVideoBasic> getResults() {
        return results;
    }

    public void setResults(List<OmdbVideoBasic> results) {
        if (results == null || results.isEmpty()) {
            // looks like an error or no results
            setResponse(false);
            setError("No results returned");
        } else {
            setResponse(true);
            setError(results.size() + " results returned");
            this.results = results;
        }
    }
}
