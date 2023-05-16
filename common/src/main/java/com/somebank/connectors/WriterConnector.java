package com.somebank.connectors;

public interface WriterConnector<S> {
    S write(S data);
}
