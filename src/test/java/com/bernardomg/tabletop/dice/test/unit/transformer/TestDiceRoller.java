/**
 * Copyright 2014-2019 the original author or authors
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

package com.bernardomg.tabletop.dice.test.unit.transformer;

import java.util.Iterator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DefaultDiceOperand;
import com.bernardomg.tabletop.dice.random.NumberGenerator;
import com.bernardomg.tabletop.dice.transformer.DiceRoller;
import com.google.common.collect.Iterables;

/**
 * Unit tests for {@link DiceRoller}, verifying that handles dice correctly.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class TestDiceRoller {

    /**
     * Default constructor.
     */
    public TestDiceRoller() {
        super();
    }

    /**
     * Verifies that the roller returns a value for each dice set.
     */
    @Test
    public final void testTransform_MultipleDice_AggregatesRolls() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Integer rolled;
        final NumberGenerator generator;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(2);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate(ArgumentMatchers.any())).thenReturn(1,
                2, 3);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller(generator).transform(expression).getFinalRoll();

        Assertions.assertEquals(new Integer(3), rolled);
    }

    /**
     * Verifies that the roller returns a value for each dice set.
     */
    @Test
    public final void testTransform_MultipleDice_ReturnsHistory() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Iterable<RollResult> rolled;
        final RollResult rolledValues;
        final NumberGenerator generator;
        final Iterator<Integer> rolls;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(2);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate(ArgumentMatchers.any())).thenReturn(1,
                2, 3);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller(generator).transform(expression)
                .getRollResults();
        rolledValues = rolled.iterator().next();

        Assertions.assertEquals(1, Iterables.size(rolled));

        Assertions.assertEquals(2, Iterables.size(rolledValues.getAllRolls()));

        rolls = rolledValues.getAllRolls().iterator();

        Assertions.assertEquals(new Integer(1), rolls.next());
        Assertions.assertEquals(new Integer(2), rolls.next());
    }

    /**
     * Verifies that the roller returns the values generated by its number
     * generator.
     */
    @Test
    public final void testTransform_ReturnsGenerated() {
        final Dice dice;
        final DiceNotationExpression expression;
        final Integer rolled;
        final NumberGenerator generator;

        // Mocks dice
        dice = Mockito.mock(Dice.class);
        Mockito.when(dice.getQuantity()).thenReturn(1);
        Mockito.when(dice.getSides()).thenReturn(1);

        // Mocks generator
        generator = Mockito.mock(NumberGenerator.class);
        Mockito.when(generator.generate(ArgumentMatchers.any())).thenReturn(5);

        expression = new DefaultDiceOperand(dice);

        rolled = new DiceRoller(generator).transform(expression).getFinalRoll();

        Assertions.assertEquals(new Integer(5), rolled);
    }

}
