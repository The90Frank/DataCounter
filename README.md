# DataCounter

A generic Java data structure that counts element frequencies, with two interchangeable implementations: hash-based and tree-based.

## Overview

`DataCounter<E>` provides an interface to track how many times each element appears in a collection. The typical use case is counting word frequencies in text documents.

Two implementations are available:

- **HashDataCounter** - backed by `Hashtable<E, Integer>` for O(1) average-case lookups
- **TreeDataCounter** - backed by `TreeMap<E, Integer>` for ordered storage

Both implement `Iterable<E>` and provide a randomized iterator over the stored elements.

## API

| Method | Description |
|---|---|
| `AddElement(E data)` | Add a new element with initial count of 1 |
| `incCount(E data)` | Increment the count for an existing element |
| `getCount(E data)` | Get the current count for an element |
| `getSize()` | Get the number of unique elements |
| `iterator()` | Iterate over elements in random order |

## Project structure

```
datacounter/
├── DataCounter.java          # Generic interface
├── DataCounterAbsCls.java    # Abstract base class
├── DataCounterException.java # Custom exception
├── HashDataCounter.java      # Hash-based implementation
├── TreeDataCounter.java      # Tree-based implementation
└── Test.java                 # Test suite and word frequency demo
```

## Usage

```java
DataCounter<String> counter = new HashDataCounter<>();
counter.AddElement("word");
counter.incCount("word");
int count = counter.getCount("word");
```

The test suite (`Test.java`) demonstrates reading text files, tokenizing words, and producing frequency-sorted output.

## License

Apache License 2.0 - see [LICENSE](LICENSE) for details.
