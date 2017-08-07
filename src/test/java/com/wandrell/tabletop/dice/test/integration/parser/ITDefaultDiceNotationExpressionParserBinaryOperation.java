/**
 * Copyright 2014-2017 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.dice.test.integration.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wandrell.tabletop.dice.notation.operand.DiceOperand;
import com.wandrell.tabletop.dice.notation.operand.IntegerOperand;
import com.wandrell.tabletop.dice.notation.operation.AdditionOperation;
import com.wandrell.tabletop.dice.notation.operation.BinaryOperation;

/**
 * Integration tests for {@code DefaultDiceNotationExpressionParser}, checking that it
 * parses simple binary operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class ITDefaultDiceNotationExpressionParserBinaryOperation
        extends AbstractITDefaultDiceNotationExpressionParser {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserBinaryOperation() {
        super();
    }

    /**
     * Tests that an addition using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Add_Dice() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        final DiceOperand diceLeft;        // Left parsed dice
        final DiceOperand diceRight;       // Right parsed dice

        notation = "1d20+2d6";

        operation = (AdditionOperation) parse(notation);

        diceLeft = (DiceOperand) operation.getLeft();
        diceRight = (DiceOperand) operation.getRight();

        Assert.assertEquals(diceLeft.getDice().getQuantity(), (Integer) 1);
        Assert.assertEquals(diceLeft.getDice().getSides(), (Integer) 20);

        Assert.assertEquals(diceRight.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(diceRight.getDice().getSides(), (Integer) 6);
    }

    /**
     * Tests that an addition with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Add_LeftNumber() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        final IntegerOperand integer;      // Parsed integer
        final DiceOperand dice;            // Parsed dice

        notation = "5+2d6";

        operation = (AdditionOperation) parse(notation);

        dice = (DiceOperand) operation.getRight();
        integer = (IntegerOperand) operation.getLeft();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);
    }

    /**
     * Tests that an addition with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Add_RightNumber() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        final IntegerOperand integer;      // Parsed integer
        final DiceOperand dice;            // Parsed dice

        notation = "2d6+5";

        operation = (AdditionOperation) parse(notation);

        dice = (DiceOperand) operation.getLeft();
        integer = (IntegerOperand) operation.getRight();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);
    }

    /**
     * Tests that an addition with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Add() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation

        notation = "1+2";

        operation = (AdditionOperation) parse(notation);

        Assert.assertEquals(operation.getLeft().getValue(), (Integer) 1);
        Assert.assertEquals(operation.getRight().getValue(), (Integer) 2);
    }

    /**
     * Tests that long additions can be parsed, and the result is the expected
     * one.
     */
    @Test
    public final void testParse_Number_Add_Long() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final AdditionOperation value;

        notation = "1+2+3";

        value = (AdditionOperation) parse(notation);

        Assert.assertEquals(value.getLeft().getValue(), (Integer) 1);

        operation = (BinaryOperation) value.getRight();
        Assert.assertEquals(operation.getLeft().getValue(), (Integer) 2);
        Assert.assertEquals(operation.getRight().getValue(), (Integer) 3);
    }

    /**
     * Tests that longer additions can be parsed, and the result is the expected
     * one.
     */
    @Test
    public final void testParse_Number_Add_Longer() {
        final String notation;             // Input to parse
        final AdditionOperation operation; // Parsed operation
        BinaryOperation value;

        notation = "1+2+3+4+5";

        operation = (AdditionOperation) parse(notation);

        value = (BinaryOperation) operation.getRight();
        Assert.assertEquals(value.getLeft().getValue(), (Integer) 2);

        value = (BinaryOperation) value.getRight();
        Assert.assertEquals(value.getLeft().getValue(), (Integer) 3);

        value = (BinaryOperation) value.getRight();
        Assert.assertEquals(value.getLeft().getValue(), (Integer) 4);
        Assert.assertEquals(value.getRight().getValue(), (Integer) 5);
    }

    /**
     * Tests that additions followed by subtractions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_Number_AddAndSub() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final BinaryOperation value;     // Parsed right operation

        notation = "1+2-3";

        operation = (BinaryOperation) parse(notation);

        Assert.assertEquals(operation.getLeft().getValue(), (Integer) 1);

        value = (BinaryOperation) operation.getRight();
        Assert.assertEquals(value.getLeft().getValue(), (Integer) 2);
        Assert.assertEquals(value.getRight().getValue(), (Integer) 3);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that a subtraction with only numbers is parsed correctly.
     */
    @Test
    public final void testParse_Number_Sub() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation

        notation = "1-2";

        operation = (BinaryOperation) parse(notation);

        Assert.assertEquals(operation.getLeft().getValue(), (Integer) 1);
        Assert.assertEquals(operation.getRight().getValue(), (Integer) 2);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Long() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final BinaryOperation value;     // Parsed right operation

        notation = "1-2-3";

        operation = (BinaryOperation) parse(notation);

        Assert.assertEquals(operation.getLeft().getValue(), (Integer) 1);

        value = (BinaryOperation) operation.getRight();
        Assert.assertEquals(value.getLeft().getValue(), (Integer) 2);
        Assert.assertEquals(value.getRight().getValue(), (Integer) 3);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that long subtractions can be parsed, and the result is the
     * expected one.
     */
    @Test
    public final void testParse_Number_Sub_Longer() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        BinaryOperation value;           // Parsed sub operations

        notation = "1-2-3-4-5";

        operation = (BinaryOperation) parse(notation);

        value = (BinaryOperation) operation.getRight();
        Assert.assertEquals(value.getLeft().getValue(), (Integer) 2);

        value = (BinaryOperation) value.getRight();
        Assert.assertEquals(value.getLeft().getValue(), (Integer) 3);

        value = (BinaryOperation) value.getRight();
        Assert.assertEquals(value.getLeft().getValue(), (Integer) 4);
        Assert.assertEquals(value.getRight().getValue(), (Integer) 5);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that subtractions followed by additions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_Number_SubAndAdd() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final BinaryOperation value;     // Parsed right operation

        notation = "3-1+2";

        operation = (BinaryOperation) parse(notation);

        Assert.assertEquals(operation.getLeft().getValue(), (Integer) 3);

        value = (BinaryOperation) operation.getRight();
        Assert.assertEquals(value.getLeft().getValue(), (Integer) 1);
        Assert.assertEquals(value.getRight().getValue(), (Integer) 2);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that a subtraction using only dice is parsed correctly.
     */
    @Test
    public final void testParse_Sub_Dice() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final DiceOperand diceLeft;      // Left parsed dice
        final DiceOperand diceRight;     // Right parsed dice

        notation = "1d20-2d6";

        operation = (BinaryOperation) parse(notation);

        diceLeft = (DiceOperand) operation.getLeft();
        diceRight = (DiceOperand) operation.getRight();

        Assert.assertEquals(diceLeft.getDice().getQuantity(), (Integer) 1);
        Assert.assertEquals(diceLeft.getDice().getSides(), (Integer) 20);

        Assert.assertEquals(diceRight.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(diceRight.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that a subtraction with the number to left is parsed correctly.
     */
    @Test
    public final void testParse_Sub_LeftNumber() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final IntegerOperand integer;    // Integer operand
        final DiceOperand dice;          // Dice operand

        notation = "5-2d6";

        operation = (BinaryOperation) parse(notation);

        integer = (IntegerOperand) operation.getLeft();
        dice = (DiceOperand) operation.getRight();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(operation.getExpression(), notation);
    }

    /**
     * Tests that a subtraction with the number to right is parsed correctly.
     */
    @Test
    public final void testParse_Sub_RightNumber() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final IntegerOperand integer;    // Integer operand
        final DiceOperand dice;          // Dice operand

        notation = "2d6-5";

        operation = (BinaryOperation) parse(notation);

        dice = (DiceOperand) operation.getLeft();
        integer = (IntegerOperand) operation.getRight();

        Assert.assertEquals(dice.getDice().getQuantity(), (Integer) 2);
        Assert.assertEquals(dice.getDice().getSides(), (Integer) 6);

        Assert.assertEquals(integer.getValue(), (Integer) 5);

        Assert.assertEquals(operation.getExpression(), notation);
    }

}