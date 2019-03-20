package com.inditex;

import java.util.List;

/*Se crea la clase Direction en la que se van a especificar las direcciones N, E, S y W.*/
public enum Direction {

    NORTH(0, 'N'),
    EAST(1, 'E'),
    SOUTH(2, 'S'),
    WEST(3, 'W');
    //Se definen las variables de clase
    private int value;
    private char shortName;
    //Constructor de clase
    private Direction(int value, char name) {
        this.value = value;
        this.name = name;
    }
    //Definición de método get y set
    public int getValue() {
        return this.value;
    }
    //Recupera el identificador de texto de la dirección
    public char getShortName() { 
        return this.name; 
    }
    //Recupera la dirección opuesta a la dirección que tiene definida el objeto
    public Direction getBackDirection() {
        return values()[(this.getValue() + 2) % 4];
    }
}

//Definición de la clase punto. Contiene todo lo referente a la posición geográfica y la definición de los movimientos pedidos en el ejercicio.
public class Point {
    //Variables de clase. En este caso se han definido las coordenatas x e y, y una dirección.
    private int x;
    private int y;
    private Direction direction;
    //Constructor de clase
    public Point(int x, int y, Direction direction) {
        this.setX(x);
        this.setY(y);
        this.setDirection(direction);
    }
    //Definición de los métodos get y set
    public int getX(){
        return x;
    }
    public void setX(x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(y){
        this.y = y;
    }
    public Direction getDirection() {
        return this.direction;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    //Se crea un método privado para actualizar la posición de la nave según la dirección establecida.
    private boolean move(Direction direction) {
        //Cogiendo la descripción de la dirección actualizaremos el posicionamiento aumentando o restando una unidad al punto. 
        switch (directionValue.getShortName()) {
            case 'N':
                this.setY(this.getY() + 1);
                break;
            case 'E':
                this.setX(this.getX() + 1);
                break;
            case 'S':
                this.setY(this.getY() - 1);
                break;
            case 'W':
                this.setX(this.getX() - 1);
                break;
        }
    }
    //Este método se encarga de mover hacia adelante la nave.
    public boolean moveF() {
        //Se llama al método move con la dirección que tiene establecido el punto de la nave.
        return move(this.direction);
    }
    //Este método se encarga de mover hacia atrás la nave.
    public boolean moveB() {
        //Se llama al método move con la dirección contraria que tiene establecido el punto de la nave.
        return move(this.direction.getBackDirection());
    }
    //Este método cambia la dirección del punto de la nave.
    private void changeDirection(char dir Direction int dirStep) {
        int newDir = (dir == 'l') ? -1 : 1;
        int directions = Direction.values().length;
        this.direction = Direction.values()[(directions + direction.getValue() + newDir) % directions];
    }
}

//Se crea la clase MarsRover con objeto del robot de Marte. Tendrá como atributo un objeto de tipo Point que contiene los datos de posicionamiento y los métodos que se llaman para la ejecución de los comandos recibidos.
public class MarsRover {
    // Se define la variable Point.
    private Point point;
    // Se define el constructor de clase.
    public MarsRover(Point point) {
        this.point = point;
    }
    // Se definen los métodos get y set de la clase.
    public Point getPoint() {
        return this.point;
    }
    public void setPoint(Point point) {
        this.point = point;
    }
    // Este método recibirá un array con los comandos e irá llamando uno a uno los comandos introducidos.
    public void commandsExecution(String commands) throws Exception {
        for (char command : commands.toCharArray()) {
            if (!commandsSingleExecution(command)) {
                break;
            }
        }
    }
    // Este método se encarga de la ejecución unitaria de cada uno de los comandos introducidos. 
    private boolean commandsSingleExecution(char command) throws Exception {
        //Se contemplan los 2 movimientos y los 3 cambios de dirección.
        switch(Character.toLowerCase(command)) {
            // Movimiento hacia delante.
            case 'f':
                return getPoint().moveF();
            // Movimiento hacia atrás.
            case 'b':
                return getPoint().moveB();
            // Cambio de dirección a la izquierda.
            case 'l':
                getPoint().changeDirection(Character.toLowerCase(command));
                return true;
            case 'r':
            // Cambio de dirección a la derecha.
                getPoint().changeDirection(Character.toLowerCase(command));
                return true;
            default:
                throw new Exception("Command unknown" + command);
        }
    }  
}

