package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(1L)
                .organizationName("Kat Laydee")
                .address("123 Feline Street, Meow Town")
                .build());
        organizerList.add(Organizer.builder()
                .id(2L)
                .organizationName("Fern Pollin")
                .address("456 Flora Avenue, Flora City")
                .build());
        organizerList.add(Organizer.builder()
                .id(3L)
                .organizationName("Carey Wales")
                .address("789 Ocean Drive, Playa Del Carmen")
                .build());
        organizerList.add(Organizer.builder()
                .id(4L)
                .organizationName("Dawg Dahd")
                .address("321 Woof Lane, Woof Town")
                .build());
        organizerList.add(Organizer.builder()
                .id(5L)
                .organizationName("Kahn Opiner")
                .address("654 Tin Street, Tin City")
                .build());
        organizerList.add(Organizer.builder()
                .id(6L)
                .organizationName("Brody Kill")
                .address("987 Highway 50, Rural Area")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
        int firstIndex = (page - 1) * pageSize;
        return organizerList.subList(firstIndex, Math.min(firstIndex + pageSize, organizerList.size()));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
}
