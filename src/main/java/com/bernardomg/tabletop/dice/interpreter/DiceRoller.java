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

package com.bernardomg.tabletop.dice.interpreter;

import java.util.function.Function;

import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.history.RollResult;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.random.NumberGenerator;
import com.bernardomg.tabletop.dice.random.RandomNumberGenerator;
import com.bernardomg.tabletop.dice.roll.DefaultRollGenerator;
import com.bernardomg.tabletop.dice.roll.RollGenerator;
import com.bernardomg.tabletop.dice.visitor.DiceRollAccumulator;

/**
 * Dice notation expression which simulates rolling the expression.
 * <p>
 * As some values, such as dice, represent random numbers the transformer may
 * not return the same result each time it is executed for the same expression.
 * <p>
 * The random value will be generated by a {@link NumberGenerator} contained in
 * the transformer, which can be set through the constructor. Otherwise the
 * default one, a {@link RandomNumberGenerator}, will be used.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DiceRoller implements DiceInterpreter<RollHistory> {

    /**
     * Wrapped interpreter. Configured for the required operations.
     */
    private final DiceInterpreter<RollHistory> wrapped;

    /**
     * Default constructor.
     */
    public DiceRoller() {
        this(new DefaultRollGenerator());
    }

    /**
     * Constructs a transformer using the transformer on the rolls.
     * 
     * @param transformer
     *            transformer to apply
     */
    public DiceRoller(final Function<RollResult, RollResult> transformer) {
        this(new DefaultRollGenerator(), transformer);
    }

    /**
     * Constructs a transformer using the received roller for simulating rolls.
     * 
     * @param generator
     *            the random number generator to use
     */
    public DiceRoller(final NumberGenerator generator) {
        this(new DefaultRollGenerator(generator));
    }

    /**
     * Constructs a transformer using the received roller for simulating rolls
     * and the received transformer on the rolls.
     * 
     * @param generator
     *            the random number generator to use
     * @param transformer
     *            transformer to apply
     */
    public DiceRoller(final NumberGenerator generator,
            final Function<RollResult, RollResult> transformer) {
        this(new DefaultRollGenerator(generator), transformer);
    }

    /**
     * Constructs a transformer using the received roll generator for simulating
     * rolls.
     * 
     * @param roller
     *            the roller to use
     */
    public DiceRoller(final RollGenerator roller) {
        super();

        wrapped = new ConfigurableInterpreter<>(new PostorderTraverser(),
                new DiceRollAccumulator(roller));
    }

    /**
     * Constructs a transformer using the received roll generator for simulating
     * rolls and the received transformer on the rolls.
     * 
     * @param roller
     *            the roller to use
     * @param transformer
     *            transformer to apply
     */
    public DiceRoller(final RollGenerator roller,
            final Function<RollResult, RollResult> transformer) {
        super();

        wrapped = new ConfigurableInterpreter<>(new PostorderTraverser(),
                new DiceRollAccumulator(roller, transformer));
    }

    @Override
    public final RollHistory
            transform(final DiceNotationExpression expression) {
        return wrapped.transform(expression);
    }

}
