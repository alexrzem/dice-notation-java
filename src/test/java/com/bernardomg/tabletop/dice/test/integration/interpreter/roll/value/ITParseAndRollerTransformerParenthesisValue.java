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

package com.bernardomg.tabletop.dice.test.integration.interpreter.roll.value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

/**
 * Integration tests for {@link DiceRoller}, verifying that it transforms simple
 * binary operations.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITParseAndRollerTransformerParenthesisValue {

    /**
     * Default constructor.
     */
    public ITParseAndRollerTransformerParenthesisValue() {
        super();
    }

    /**
     * Verifies that parenthesis are applied, and the result is the expected
     * one.
     */
    @Test
    public final void testParse_AddAndMult_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "(1+2)*3";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(9), result);
    }

    /**
     * Verifies that parenthesis are applied, and the result is the expected
     * one.
     */
    @Test
    public final void testParse_Number_Value() {
        final DiceNotationExpression parsed; // Parsed expression
        final Integer result;                // Resulting value
        final String notation;               // Input to parse

        notation = "(1)";

        parsed = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(parsed).getTotalRoll();

        Assertions.assertEquals(new Integer(1), result);
    }

}
