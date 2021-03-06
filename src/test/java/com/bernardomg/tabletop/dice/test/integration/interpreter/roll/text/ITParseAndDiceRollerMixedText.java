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

package com.bernardomg.tabletop.dice.test.integration.interpreter.roll.text;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.interpreter.DiceRoller;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DiceRoller returns the expected text representation for mixed binary operations")
public final class ITParseAndDiceRollerMixedText {

    /**
     * Default constructor.
     */
    public ITParseAndDiceRollerMixedText() {
        super();
    }

    /**
     * Verifies that an addition generates the expected results.
     */
    @Test
    public final void testRolls_AddSub() {
        final DiceNotationExpression expression;
        final String notation;
        final RollHistory result;

        notation = "1+2-3";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression);

        Assertions.assertEquals("1 + 2 - 3", result.toString());
    }

    /**
     * Verifies that an addition generates the expected results.
     */
    @Test
    public final void testRolls_AddSub_Parenthesis() {
        final DiceNotationExpression expression;
        final String notation;
        final RollHistory result;

        notation = "1+(2-3)";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression);

        Assertions.assertEquals("1 + 2 - 3", result.toString());
    }

    /**
     * Verifies that an addition generates the expected results.
     */
    @Test
    public final void testRolls_DiceAddAndDiv_Text() {
        final DiceNotationExpression expression;
        final String notation;
        final RollHistory result;

        notation = "1d1+4d1/2d1";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression);

        Assertions.assertEquals("1 + [1, 1, 1, 1] / [1, 1]", result.toString());
    }

    /**
     * Verifies that an addition generates the expected results.
     */
    @Test
    public final void testRolls_DiceAddAndMult_Text() {
        final DiceNotationExpression expression;
        final String notation;
        final RollHistory result;

        notation = "1d1+2d1*3d1";

        expression = new DefaultDiceParser().parse(notation);

        result = new DiceRoller().transform(expression);

        Assertions.assertEquals("1 + [1, 1] * [1, 1, 1]", result.toString());
    }

}
