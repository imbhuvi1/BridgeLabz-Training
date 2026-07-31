# Day 1 — DBMS Fundamentals & RDBMS Basics

## 📌 Summary

- Learned the foundational hierarchy: **Data → Database → DBMS → RDBMS**
- Compared **File Systems vs DBMS**, and understood DBMS advantages (reduced redundancy, integrity, security, concurrency)
- Explored **types of DBMS** (Hierarchical, Network, Relational, Object-Oriented, NoSQL)
- Deeply understood **RDBMS features**, and made the critical **SQL vs NoSQL** decision framework
- Installed **MySQL** on Windows, understood its **internal architecture** (Connection → SQL → Storage Engine layers)
- Practiced **DDL** (CREATE, ALTER, DROP, TRUNCATE, RENAME) and **DML** (INSERT, UPDATE, DELETE)
- Got introduced to **TCL** (COMMIT/ROLLBACK) and **DCL** (GRANT/REVOKE) — previewing concepts fully explored on Day 4
- Built the first two tables of our Health Clinic Database: `patients` and `doctors`

## ✅ Assignment

| # | Task | Status |
|---|------|--------|
| 1 | Install MySQL and verify using `SELECT VERSION();` | ✅ Done |
| 2 | Create a database named `health_clinic_db` | ✅ Done |
| 3 | Create `specializations` (id, name, description) and `appointments` (id, patient_id, doctor_id, appointment_date) tables — no foreign keys yet | ✅ Done |
| 4 | Insert at least 3 sample rows into each new table | ✅ Done |
| 5 | Practice `ALTER TABLE` — add a column, then drop it | ✅ Done |
| 6 | Write one `UPDATE` and one `DELETE` query with `WHERE`, verified via `SELECT` before/after | ✅ Done |
| 7 | Create `clinic_app_user` with `SELECT`, `INSERT`, `UPDATE`, `DELETE` privileges only on `health_clinic_db` | ✅ Done |

📄 **Assignment solution:** [https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-1/Assignment]

## 🗂️ Concepts Covered

- Data vs Information vs Database vs DBMS vs RDBMS
- File System vs DBMS, advantages of DBMS
- Types of DBMS, RDBMS features
- SQL vs NoSQL decision-making
- MySQL introduction, architecture, installation
- DDL / DML / TCL / DCL commands

## 🧠 Interview & Practice Questions

Reviewed and answered all interview and practice questions for Day 1 (not included here).
