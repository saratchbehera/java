package com.sarat.automatedUKIndexJournals.fileUpload.exception;

public class IndexFileStorageException extends RuntimeException {
    public IndexFileStorageException(String message) {
        super(message);
    }

    public IndexFileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
