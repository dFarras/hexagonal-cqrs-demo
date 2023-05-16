package com.somebank.connectors;

import java.util.Optional;

public interface ReaderConnector<T, S> {
    Optional<T> read(S id);
}
