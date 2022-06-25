package coordinatecalculator.domain.graph;

@FunctionalInterface
public interface StringBuilderStrategy {

    void append(StringBuilder stringBuilder);
}
