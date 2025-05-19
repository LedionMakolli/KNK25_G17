package services;

import models.Dto.CreateStafDto;
import models.Dto.UpdateStafDto;
import models.Staff;
import repository.StaffRepository;

import java.sql.SQLException;
import java.util.List;

public class StaffService {
    private StaffRepository staffRepository;

    public StaffService()  {
        try {
            this.staffRepository = new StaffRepository();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Staff getById(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("Invalid ID!");
        }
        Staff staff = this.staffRepository.getById(id);
        if (staff == null) {
            throw new Exception("Staff with ID " + id + " does not exist!");
        }
        return staff;
    }

    public Staff create(CreateStafDto createStafDto) throws Exception {
        if (createStafDto.getFirstName() == null || createStafDto.getFirstName().trim().isEmpty() ||
                createStafDto.getLastName() == null || createStafDto.getLastName().trim().isEmpty() ||
                createStafDto.getAge() <= 12 || createStafDto.getEmail() == null || createStafDto.getEmail().trim().isEmpty()) {
            throw new Exception("Client data is not valid!");
        }

        Staff staff = this.staffRepository.create(createStafDto);
        if (createStafDto == null) {
            throw new Exception("Client not created!");
        }
        return staff;
    }


    public Staff update(UpdateStafDto updateStafDto) throws Exception {
        if (updateStafDto.getId() <= 0) {
            throw new Exception("Invalid ID for update!");
        }

        Staff updatedStaff = this.staffRepository.update(updateStafDto);
        if (updatedStaff == null) {
            throw new Exception("Client update failed!");
        }

        return updatedStaff;
    }

    public List<Staff> getAllStaff(){
        return this.staffRepository.getAll();
    }
}
