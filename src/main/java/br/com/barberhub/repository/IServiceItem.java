package br.com.barberhub.repository;

import br.com.barberhub.entities.ServiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IServiceItem extends JpaRepository<Long, ServiceItem> {

    Optional<ServiceItem> findById(Long id);


}
