package com.portal.DTO;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) representing admin registration information.
 */
public class ApiResponseDTO {
    /**
     * The message contained in the API response.
     */
    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param messageParam the message to set
     */
    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    /**
     * Generates a hash code for this ApiResponseDTO based on its message.
     *
     * @return A hash code value for this ApiResponseDTO.
     */
    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    /**
     * @param obj The object to compare with this ApiResponseDTO.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ApiResponseDTO other = (ApiResponseDTO) obj;
        return Objects.equals(message, other.message);
    }

    /**
     * Returns a string representation of this ApiResponseDTO, including its
     * message.
     *
     * @return A string representation of this ApiResponseDTO.
     */
    @Override
    public String toString() {
        return "ApiResponseDTO [message=" + message + "]";
    }
}
