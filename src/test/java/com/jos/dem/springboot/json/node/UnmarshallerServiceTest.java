package com.jos.dem.springboot.json.node;

import com.fasterxml.jackson.databind.JsonNode;
import com.jos.dem.springboot.json.node.model.Event;
import com.jos.dem.springboot.json.node.model.Message;
import com.jos.dem.springboot.json.node.service.UnmarshallerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.time.OffsetDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class UnmarshallerServiceTest {


    private Event event;
    private Message message;

    private final UnmarshallerService service;

    @BeforeEach
    void init() throws Exception {
        log.info("Getting Event from ClockIn json file");
        File jsonFile = new File("src/main/resources/ClockIn.json");
        event = service.read(jsonFile);
        Message[] messages = event.getMessages();
        message = messages[0];
    }

    @Test
    @DisplayName("Validate Event value from ClockIn Json file")
    void shouldGetEventFromClockInFile(TestInfo testInfo) {
        log.info("Running: {}", testInfo.getDisplayName());

        assertAll("event",
                () -> assertEquals("fbe07c89-ffa7-4c86-9832-5f75cf765737", event.getBatchId(), "Should get batch id"),
                () -> assertEquals("EmployeeClockIn", event.getEventType(), "Should get event type"),
                () -> assertEquals(OffsetDateTime.parse("2019-03-09T12:36:43Z"), event.getPublishedAt(), "Should get published at time")
        );

    }

    @Test
    @DisplayName("Validate Message values from Event")
    void shouldGetMessageFromEvent(TestInfo testInfo) {
        log.info("Running: {}", testInfo.getDisplayName());

        assertAll("message",
                () -> assertEquals("4aeaa175-e46d-42eb-83d3-cd02865d4863", message.getMessageId(), "Should get message id"),
                () -> assertEquals(OffsetDateTime.parse("2019-03-09T12:36:43Z"), event.getPublishedAt(), "Should get published at time")
        );

    }

    @Test
    @DisplayName("Validate Data values from message")
    void shouldGetDataFromMessage(TestInfo testInfo) {
        log.info("Running: {}", testInfo.getDisplayName());
        
        JsonNode data = message.getData();
        assertAll("data",
                () -> assertEquals("Jose", data.get("firstname").textValue(), "Should get Firstname"),
                () -> assertEquals("Morales", data.get("lastname").textValue(), "Should get Lastname"),
                () -> assertEquals("josdem", data.get("nickname").textValue(), "Should get Nickname"),
                () -> assertEquals(1196, data.get("employeeNumber").intValue(), "Should get Employee Number"),
                () -> assertEquals("joseluis.delacruz@gmail.com", data.get("email").textValue(), "Should get Email"),
                () -> assertEquals("2019-03-09T07:36:43-05:00", data.get("clockInDateTime").textValue(), "Should get clockIn time")
        );

    }

}
