package com.cbfacademy.apiassessment.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.jackson.JsonComponent;

import com.cbfacademy.apiassessment.model.PastEarnings;
import com.cbfacademy.apiassessment.model.PastEarningsAnnual;
import com.cbfacademy.apiassessment.model.PastEarningsQuarterly;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


/**Format for deserialising the JSONAPI response for pastearnings */
@JsonComponent
public class PastEarningsJSONDeserializer extends JsonDeserializer<PastEarnings> {

    private static final String DATE_PATTERN = "YYYY-MM-DD";

    @Override
    public PastEarnings deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JacksonException {

        JsonNode jsonNode = p.getCodec().readTree(p);

        JsonNode symbol = jsonNode.get("symbol");
        JsonNode pastAnnualEarnings = jsonNode.get("annualEarnings");
        JsonNode pastQuarterlyEarnings = jsonNode.get("quarterlyEarnings");

        String symString = symbol.get("symbol").asText();

        List<PastEarningsAnnual> pastEarningsAnnualsList = new ArrayList<>();
        if (pastAnnualEarnings.isArray()) {
            for (JsonNode jn : pastAnnualEarnings) {
                PastEarningsAnnual pEAnnual = new PastEarningsAnnual(
                        getDate(jn.get("fiscalDateEnding")),
                        jn.get("reportedEPS").asDouble());

                pastEarningsAnnualsList.add(pEAnnual);
            }
        }

        List<PastEarningsQuarterly> pastEarningsQuarterlyList = new ArrayList<>();
        if (pastQuarterlyEarnings.isArray()) {
            for (JsonNode jn : pastQuarterlyEarnings) {
                PastEarningsQuarterly pEQuarterly = new PastEarningsQuarterly(
                        getDate(jn.get("fiscalDateEnding")),
                        getDate(jn.get("reportedDateEnding")),
                        jn.get("reportedEPS").asDouble(),
                        jn.get("estimatedEPS").asDouble(),
                        jn.get("surprise").asDouble(),
                        jn.get("surprisePercentage").asDouble());

                pastEarningsQuarterlyList.add(pEQuarterly);

            }
        }

        return new PastEarnings(symString, pastEarningsAnnualsList, pastEarningsQuarterlyList);
    }

    private LocalDate getDate(JsonNode node) {
        return LocalDate.parse(node.asText(), DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

}