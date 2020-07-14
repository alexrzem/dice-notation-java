/**
 * Copyright 2014-2020 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.interpreter.roller.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.DivisionOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;

@DisplayName("DiceRoller handles division operations")
public final class TestDiceRollerDivisionOperationValue {

    /**
     * Default constructor.
     */
    public TestDiceRollerDivisionOperationValue() {
        super();
    }

    @Test
    @DisplayName("A division returns the expected result")
    public final void testTotalRoll() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final Integer rolled;

        left = new IntegerOperand(2);
        right = new IntegerOperand(1);

        // 2 / 1
        operation = new DivisionOperation(left, right);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(2), rolled);
    }

    @Test
    @DisplayName("A division (negative divisor) returns the expected result")
    public final void testTotalRoll_DivideByNegative() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final Integer rolled;

        left = new IntegerOperand(2);
        right = new IntegerOperand(-1);

        // 2 / -1
        operation = new DivisionOperation(left, right);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(-2), rolled);
    }

    @Test
    @DisplayName("A division (grouped divisor with negative) returns the expected result")
    public final void testTotalRoll_DivideByNegative_Grouped() {
        final BinaryOperation grouped;      // Tested operation
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final DiceNotationExpression value; // Right operand
        final Integer rolled;

        value = new IntegerOperand(1);

        left = new IntegerOperand(2);
        right = new IntegerOperand(3);

        grouped = new SubtractionOperation(left, right);

        // 1 / (2 - 3)
        // = 1 / -1
        // = -1
        operation = new DivisionOperation(value, grouped);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(-1), rolled);
    }

    /**
     * Verifies that multiplications of negative values are handled correctly.
     */
    @Test
    @DisplayName("A division (negative dividend) returns the expected result")
    public final void testTotalRoll_DivideNegative() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final Integer rolled;

        left = new IntegerOperand(-2);
        right = new IntegerOperand(1);

        // -2 / 1
        operation = new DivisionOperation(left, right);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(-2), rolled);
    }

    @Test
    @DisplayName("A division (grouped dividend with a negative) returns the expected result")
    public final void testTotalRoll_DivideNegative_Grouped() {
        final BinaryOperation grouped;      // Tested operation
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final DiceNotationExpression value; // Right operand
        final Integer rolled;

        left = new IntegerOperand(1);
        right = new IntegerOperand(5);

        grouped = new SubtractionOperation(left, right);

        value = new IntegerOperand(2);

        // (1 - 5) / 2
        // = -4 / 2
        // = -2
        operation = new DivisionOperation(grouped, value);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(-2), rolled);
    }

    @Test
    @DisplayName("A division (negative values) returns the expected result")
    public final void testTotalRoll_DivideNegatives() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final Integer rolled;

        left = new IntegerOperand(-2);
        right = new IntegerOperand(-1);

        // -2 / -1
        operation = new DivisionOperation(left, right);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(2), rolled);
    }

    @Test
    @DisplayName("A division (grouped negatives) returns the expected result")
    public final void testTotalRoll_GroupedNegatives() {
        final BinaryOperation operation;     // Tested operation
        final BinaryOperation groupeda;      // Tested operation
        final BinaryOperation groupedb;      // Tested operation
        final DiceNotationExpression lefta;  // Left operand
        final DiceNotationExpression righta; // Right operand
        final DiceNotationExpression leftb;  // Left operand
        final DiceNotationExpression rightb; // Right operand
        final Integer rolled;

        lefta = new IntegerOperand(1);
        righta = new IntegerOperand(2);

        groupeda = new SubtractionOperation(lefta, righta);

        leftb = new IntegerOperand(3);
        rightb = new IntegerOperand(4);

        groupedb = new SubtractionOperation(leftb, rightb);

        // (1 - 2) / (3 - 4)
        // = (-1) / (-1)
        // = -1 / -1
        // = 1
        operation = new DivisionOperation(groupeda, groupedb);

        rolled = new DiceRoller().transform(operation).getTotalRoll();

        Assertions.assertEquals(new Integer(1), rolled);
    }

    @Test
    @DisplayName("A division (zeros) returns the expected result")
    public final void testTotalRoll_Zeroes() {
        final BinaryOperation operation;    // Tested operation
        final DiceNotationExpression left;  // Left operand
        final DiceNotationExpression right; // Right operand
        final Executable closure;

        left = new IntegerOperand(0);
        right = new IntegerOperand(0);

        // 0 / 0
        operation = new DivisionOperation(left, right);

        closure = () -> new DiceRoller().transform(operation);

        Assertions.assertThrows(Exception.class, closure);
    }

}
