package coordinatecalculator.domain;

@FunctionalInterface
public interface StringBuilderStrategy {

    void append(StringBuilder stringBuilder);
}
