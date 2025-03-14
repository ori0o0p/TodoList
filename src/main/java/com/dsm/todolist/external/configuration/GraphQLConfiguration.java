package com.dsm.todolist.external.configuration;

import com.dsm.todolist.internal.core.domain.model.primitive.IsSuccess;
import com.dsm.todolist.internal.core.domain.model.primitive.Key;
import com.dsm.todolist.internal.core.domain.model.primitive.Todo;
import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
class GraphQLConfiguration {

    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .scalar(GraphQLScalarType.newScalar()
                        .name("Key")
                        .description("todo 키")
                        .coercing(new KeyScalarCoercing())
                        .build())
                .scalar(GraphQLScalarType.newScalar()
                        .name("Todo")
                        .description("todo 내용")
                        .coercing(new TodoScalarCoercing())
                        .build())
                .scalar(GraphQLScalarType.newScalar()
                        .name("IsSuccess")
                        .description("todo 완료 여부")
                        .coercing(new IsSuccessScalarCoercing())
                        .build());
    }

    private static class KeyScalarCoercing implements Coercing<Key, String> {

        @Override
        public String serialize(final Object dataFetcherResult) throws CoercingSerializeException {
            if (dataFetcherResult instanceof Key) {
                return dataFetcherResult.toString();
            }
            throw new CoercingSerializeException("Expected a Key object");
        }

        @Override
        public Key parseValue(final Object input) throws CoercingParseValueException {
            return new Key(input.toString());
        }

        @Override
        public Key parseLiteral(final Object input) throws CoercingParseLiteralException {
            if (input instanceof StringValue stringValue) {
                return new Key(stringValue.getValue());
            }
            throw new CoercingParseLiteralException("Expected a StringValue");
        }

    }

    private static class TodoScalarCoercing implements Coercing<Todo, String> {

        @Override
        public String serialize(final Object dataFetcherResult) throws CoercingSerializeException {
            if (dataFetcherResult instanceof Todo) {
                return dataFetcherResult.toString();
            }
            throw new CoercingSerializeException("Expected a todo object");
        }

        @Override
        public Todo parseValue(final Object input) throws CoercingParseValueException {
            return new Todo(input.toString());
        }

        @Override
        public Todo parseLiteral(final Object input) throws CoercingParseLiteralException {
            if (input instanceof StringValue stringValue) {
                return new Todo(stringValue.getValue());
            }
            throw new CoercingParseLiteralException("Expected a StringValue");
        }

    }

    private static class IsSuccessScalarCoercing implements Coercing<IsSuccess, Boolean> {

        @Override
        public Boolean serialize(Object dataFetcherResult) throws CoercingSerializeException {
            if (dataFetcherResult instanceof IsSuccess isSuccess) {
                return isSuccess.value();
            }
            throw new CoercingSerializeException("Expected an IsSuccess object");
        }

        @Override
        public IsSuccess parseValue(Object input) throws CoercingParseValueException {
            if (input instanceof Boolean bool) {
                return IsSuccess.getInstance(bool);
            }
            throw new CoercingParseValueException("Expected a Boolean");
        }

        @Override
        public IsSuccess parseLiteral(Object input) throws CoercingParseLiteralException {
            if (input instanceof Boolean bool) {
                return IsSuccess.getInstance(bool);
            }
            throw new CoercingParseLiteralException("Expected a Boolean");
        }

    }

}
