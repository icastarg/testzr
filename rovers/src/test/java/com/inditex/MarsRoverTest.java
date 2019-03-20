
package com.inditex;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MarsRoverTest {

    private Point point;
    private int x;
    private int y;
    private Direction direction;
    
    @Before
    public void beforePointTest() {
        x = 45;
        y = 25;
        direction = new Direction(0, 'N');
        point = new Point(x, y, direction);
    }

    @Test
    public void newInstanceShouldSetXAndYParams() {
        assertThat(point.getX()).isEqualToComparingFieldByField(x);
        assertThat(point.getY()).isEqualToComparingFieldByField(y);
    }

    @Test
    public void newInstanceShouldSetDirection() {
        assertThat(point.getDirection()).isEqualTo(direction);
    }

    @Test
    public void moveForwardShouldIncreaseYWhenDirectionIsNorth() {
        int expectedMove = y + 1;
        point.setDirection(Direction.NORTH);
        point.moveForward();
        assertThat(point.getY()).isEqualToComparingFieldByField(expectedMove);
    }

    @Test
    public void moveForwardShouldIncreaseXWhenDirectionIsEast() {
        int expectedMove = x + 1;
        point.setDirection(Direction.EAST);
        point.moveForward();
        assertThat(point.getX()).isEqualToComparingFieldByField(expectedMove);
    }

    @Test
    public void moveForwardShouldDecreaseYWhenDirectionIsSouth() {   
        int expectedMove = y - 1;
        point.setDirection(Direction.SOUTH);
        point.moveForward();
        assertThat(point.getY()).isEqualToComparingFieldByField(expectedMove);
    }

    @Test
    public void moveForwardShouldDecreaseXWhenDirectionIsWest() {
        int expectedMove = x - 1;
        point.setDirection(Direction.WEST);
        point.moveForward();
        assertThat(point.getX()).isEqualToComparingFieldByField(expectedMove);
    }

    @Test
    public void moveBackwardShouldDecreaseYWhenDirectionIsNorth() {
        int expectedMove = y - 1;
        point.setDirection(Direction.NORTH);
        point.moveBackward();
        assertThat(point.getY()).isEqualToComparingFieldByField(expectedMove);
    }

    @Test
    public void moveBackwardShouldDecreaseXWhenDirectionIsEast() {
        int expectedMove = x - 1;
        point.setDirection(Direction.EAST);
        point.moveBackward();
        assertThat(point.getX()).isEqualToComparingFieldByField(expectedMove);
    }

    @Test
    public void moveBackwardShouldIncreaseYWhenDirectionIsSouth() {
        int expectedMove = y + 1;
        point.setDirection(Direction.SOUTH);
        point.moveBackward();
        assertThat(point.getY()).isEqualToComparingFieldByField(expectedMove);
    }

    @Test
    public void moveBackwardShouldIncreaseXWhenDirectionIsWest() {
        int expectedMove = x + 1;
        point.setDirection(Direction.WEST);
        point.moveBackward();
        assertThat(point.getX()).isEqualToComparingFieldByField(expectedMove);
   }
}

