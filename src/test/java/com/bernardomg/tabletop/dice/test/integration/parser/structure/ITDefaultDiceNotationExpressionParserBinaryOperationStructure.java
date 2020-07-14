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

package com.bernardomg.tabletop.dice.test.integration.parser.structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.notation.operation.AdditionOperation;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.MultiplicationOperation;
import com.bernardomg.tabletop.dice.notation.operation.SubtractionOperation;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

/**
 * Integration tests for {@link DefaultDiceParser}, verifying that it parses
 * simple binary operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITDefaultDiceNotationExpressionParserBinaryOperationStructure {

    /**
     * Default constructor.
     */
    public ITDefaultDiceNotationExpressionParserBinaryOperationStructure() {
        super();
    }

    /**
     * Verifies that additions followed by multiplications can be parsed, and
     * the result is the expected one.
     */
    @Test
    public final void testParse_Number_AddAndMult_Structure() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final MultiplicationOperation mult;
        IntegerOperand number;

        notation = "1+2*3";

        // (1+(2*3))
        operation = (AdditionOperation) new DefaultDiceParser().parse(notation);

        mult = (MultiplicationOperation) operation.getRight();

        number = (IntegerOperand) mult.getLeft();
        Assertions.assertEquals((Integer) 2, number.getValue());

        number = (IntegerOperand) mult.getRight();
        Assertions.assertEquals((Integer) 3, number.getValue());

        number = (IntegerOperand) operation.getLeft();
        Assertions.assertEquals((Integer) 1, number.getValue());
    }

    /**
     * Verifies that additions followed by subtractions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_Number_AddAndSub_Structure() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        final AdditionOperation add;
        IntegerOperand number;

        notation = "1+2-3";

        // ((1+2)-3)
        operation = (SubtractionOperation) new DefaultDiceParser()
                .parse(notation);

        number = (IntegerOperand) operation.getRight();
        Assertions.assertEquals((Integer) 3, number.getValue());

        add = (AdditionOperation) operation.getLeft();

        number = (IntegerOperand) add.getRight();
        Assertions.assertEquals((Integer) 2, number.getValue());

        number = (IntegerOperand) add.getLeft();
        Assertions.assertEquals((Integer) 1, number.getValue());
    }

    /**
     * Verifies that subtractions followed by additions can be parsed, and the
     * result is the expected one.
     */
    @Test
    public final void testParse_Number_SubAndAdd_Structure() {
        final String notation;           // Input to parse
        final BinaryOperation operation; // Parsed operation
        SubtractionOperation sub;
        IntegerOperand number;

        notation = "3-1+2";

        // ((3-1)+2)
        operation = (AdditionOperation) new DefaultDiceParser().parse(notation);

        number = (IntegerOperand) operation.getRight();
        Assertions.assertEquals((Integer) 2, number.getValue());

        sub = (SubtractionOperation) operation.getLeft();

        number = (IntegerOperand) sub.getRight();
        Assertions.assertEquals((Integer) 1, number.getValue());

        number = (IntegerOperand) sub.getLeft();
        Assertions.assertEquals((Integer) 3, number.getValue());
    }

}
