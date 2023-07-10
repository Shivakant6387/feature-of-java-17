package org.example;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SwitchExpression {
    private Map<Integer, Position> positionMap = new HashMap<>();
    private int                    randomNumber;
    private Position               randomPosition;
    @BeforeEach
    public void setup() {
        positionMap.put(1, Position.GOALKEEPER);
        positionMap.put(2, Position.DEFENCE);
        positionMap.put(3, Position.MIDFIELDER);
        positionMap.put(4, Position.STRIKER);
        randomNumber = ThreadLocalRandom.current().nextInt(1, 6);
        randomPosition = Optional.ofNullable(positionMap.get(randomNumber)).orElse(Position.BENCH);
    }
    @AfterEach
    public void tearDown() {
        positionMap.clear();
    }
    @RepeatedTest(5)
    @Order(1)
    public void oldSwitchExpressionTest() {
        switch (randomPosition) {
            case GOALKEEPER:
                System.out.println("Goal Keeper: Buffon");
                break;
            case DEFENCE:
                System.out.println("Defence: Ramos");
                break;
            case MIDFIELDER:
                System.out.println("Midfielder: Messi");
                break;
            case STRIKER:
                System.out.println("Striker: Zlatan");
                break;
            default:
                System.out.println("Please select a footballer from the BENCH!");
        }
    }
    @RepeatedTest(5)
    @Order(2)
    public void newSwitchExpressionTest() {
        switch (randomPosition) {
            case GOALKEEPER -> System.out.println("Goal Keeper: Buffon");
            case DEFENCE -> System.out.println("Defence: Ramos");
            case MIDFIELDER -> System.out.println("Midfielder: Messi");
            case STRIKER -> System.out.println("Striker: Zlatan");
            default -> System.out.println("Please select a footballer from the BENCH!");
        }
    }
    @RepeatedTest(5)
    @Order(3)
    public void newSwitchExpressionWithAssignmentTest() {
        String footballer = switch (randomPosition) {
            case GOALKEEPER, DEFENCE -> {
                System.out.println("Defensive Footballer Selection!");
                yield "Defence: Ramos";
            }
            case MIDFIELDER, STRIKER -> {
                System.out.println("Offensive Footballer Selection!");
                yield "Midfielder: Messi";
            }
            default -> "Please select a footballer from the BENCH!";
        };
        System.out.println(footballer);
    }
    @Test
    public void textBlocksTest() {
        String textBlockFootballers = """
        Footballers
          with double space indentation
            and "SW TEST ACADEMY TEAM" Rocks!
        """;
        System.out.println(textBlockFootballers);
    }
    @Test
    public void textBlocksNoLineBreaksTest() {
        String textBlockFootballers = """
        Footballers \
        with double space indentation \
        and "SW TEST ACADEMY TEAM" Rocks! \
        """;
        System.out.println(textBlockFootballers);
    }
    @Test
    public void textBlocksInsertingVariablesTest() {
        String textBlockFootballers = """
        Footballers
          with double space indentation
            and "%s" Rocks!
        """.formatted("SW TEST ACADEMY TEAM");
        System.out.println(textBlockFootballers);
    }
}
