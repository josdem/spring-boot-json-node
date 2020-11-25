package com.jos.dem.springboot.json.node;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jos.dem.springboot.json.node.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class JsonNodeTest {

    private JsonNode node;
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void init() throws Exception {
        log.info("Getting Json Node from Json");
        String json = "{\"id\":1196,\"nickname\":\"josdem\",\"email\":\"joseluis.delacruz@gmail.com\"}";
        node = mapper.readTree(json);
    }


    @Test
    @DisplayName("Validate Json to JsonNode transformation")
    void shouldGetJsonNodeFromJson(TestInfo testInfo) {
        log.info("Running: {}", testInfo.getDisplayName());

        assertAll("node",
                () -> assertEquals(1196, node.get("id").intValue(), "Should get id"),
                () -> assertEquals("josdem", node.get("nickname").textValue(), "Should get nickname"),
                () -> assertEquals("joseluis.delacruz@gmail.com", node.get("email").textValue(), "should get email")
        );

    }

    @Test
    @DisplayName("Validate JsonNode to Person transformation")
    void shouldGetPersonFromJsonNode(TestInfo testInfo) throws Exception {
        log.info("Running: {}", testInfo.getDisplayName());

        Person person = mapper.treeToValue(node, Person.class);

        assertAll("person",
                () -> assertEquals(1196, person.getId(), "Should get id"),
                () -> assertEquals("josdem", person.getNickname(), "Should get nickname"),
                () -> assertEquals("joseluis.delacruz@gmail.com", person.getEmail(), "should get email")
        );

    }

    @Test
    @DisplayName("Validate Person to JsonNode transformation")
    void shouldGetJsonNodeFromPerson(TestInfo testInfo) {
        log.info("Running: {}", testInfo.getDisplayName());

        Person person = new Person(1196, "josdem", "joseluis.delacruz@gmail.com");
        JsonNode node = mapper.valueToTree(person);

        assertAll("person",
                () -> assertEquals(1196, node.get("id").intValue(), "Should get id"),
                () -> assertEquals("josdem", node.get("nickname").textValue(), "Should get nickname"),
                () -> assertEquals("joseluis.delacruz@gmail.com", node.get("email").textValue(), "should get email")
        );

    }

    @Test
    @DisplayName("Validate Arguments to Json Node transformation")
    void shouldGetJsonNodeFromArguments(TestInfo testInfo) {
        log.info("Running: {}", testInfo.getDisplayName());

        Integer id = 1196;
        String nickname = "josdem";
        String email = "joseluis.delacruz@gmail.com";

        ObjectNode object = mapper.convertValue(Map.of("orderId", "888123"), ObjectNode.class);

        JsonNode node = mapper.createObjectNode();
        ObjectNode objectNode = ((ObjectNode) node);
        objectNode.put("id", 1196);
        objectNode.put("nickname", "josdem");
        objectNode.put("email", "joseluis.delacruz@gmail.com");
        ArrayNode arrayNode = objectNode.putArray("orders");
        arrayNode.add(object);

        assertAll("person",
                () -> assertEquals(1196, node.get("id").intValue(), "Should get id"),
                () -> assertEquals("josdem", node.get("nickname").textValue(), "Should get nickname"),
                () -> assertEquals("joseluis.delacruz@gmail.com", node.get("email").textValue(), "should get email")
        );

        log.info("jsonNode: {}", node.toString());

    }

}
