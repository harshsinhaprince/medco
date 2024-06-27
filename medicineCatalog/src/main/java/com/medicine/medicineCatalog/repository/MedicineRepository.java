package com.medicine.medicineCatalog.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine.medicineCatalog.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
