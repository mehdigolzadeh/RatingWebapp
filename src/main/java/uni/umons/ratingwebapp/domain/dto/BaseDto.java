package uni.umons.ratingwebapp.domain.dto;

public interface BaseDto<T> {
    T toEntity();
}
