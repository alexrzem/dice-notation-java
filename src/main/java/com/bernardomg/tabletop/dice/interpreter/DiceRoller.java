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

import static com.google.common.base.Preconditions.checkNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.history.RollHistory;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.ConstantOperand;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.random.NumberGenerator;
import com.bernardomg.tabletop.dice.random.RandomNumberGenerator;

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
     * Logger.
     */
    private static final Logger                                     LOGGER    = LoggerFactory
            .getLogger(DiceRoller.class);

    /**
     * The random numbers generator.
     * <p>
     * Combined with the data in the rolled this, this will generate a random
     * value in an interval.
     */
    private final NumberGenerator                                   numberGenerator;

    /**
     * Transformer to generate a list from the received expression.
     */
    private final DiceInterpreter<Iterable<DiceNotationExpression>> traverser = new PostorderTraverser();

    /**
     * Default constructor.
     */
    public DiceRoller() {
        super();

        numberGenerator = new RandomNumberGenerator();
    }

    /**
     * Constructs a transformer using the received roller for simulating rolls.
     * 
     * @param generator
     *            the random number generator to use
     */
    public DiceRoller(final NumberGenerator generator) {
        super();

        numberGenerator = checkNotNull(generator,
                "Received a null pointer as generator");
    }

    @Override
    public final RollHistory
            transform(final DiceNotationExpression expression) {
        final Iterable<DiceNotationExpression> ordered;

        checkNotNull(expression, "Received a null pointer as expression");

        LOGGER.debug("Root expression {}", expression);

        ordered = traverser.transform(expression);

        return getHistory(ordered);
    }

    /**
     * Returns the final value from the parsed expression. This expression is
     * received as a postorder tree list.
     * 
     * @param expressions
     *            expressions to get the values from
     * @return the value from the expressions
     */
    private final RollHistory
            getHistory(final Iterable<DiceNotationExpression> expressions) {
        final DiceRollerVisitor visitor;

        visitor = new DiceRollerVisitor(numberGenerator);
        for (final DiceNotationExpression current : expressions) {
            if (current instanceof BinaryOperation) {
                visitor.onBinaryOperation((BinaryOperation) current);
            } else if (current instanceof ConstantOperand) {
                visitor.onConstantOperand((ConstantOperand) current);
            } else if (current instanceof DiceOperand) {
                visitor.onDiceOperand((DiceOperand) current);
            } else {
                LOGGER.warn("Unsupported expression of type {}",
                        current.getClass());
            }
        }

        return visitor.getValue();
    }

}
