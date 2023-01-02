package rs.urosvesic.notificationservice.mapper;


import rs.urosvesic.notificationservice.dto.Dto;
import rs.urosvesic.notificationservice.model.MyCollection;

/**
 * @author UrosVesic
 */

public interface GenericMapper<D extends Dto, E extends MyCollection> {

    E toEntity(D dto);

    D toDto(E entity);
}
