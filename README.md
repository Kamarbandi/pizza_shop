### Project Setup

#### Tech Stack
- **Frontend:** ReactJS
- **Backend:** Java Spring Boot
- **Database:** PostgreSQL
- **Container:** Docker

#### Initial Setup

1. **Run Docker:**
   - The database is set up using Docker. The configuration can be found in the backend's `docker-compose.yml` file.
  
2. **Create the Database:**
   - After running Docker, create a database named `pizza`.
   - Set up the corresponding tables using the `data.sql` file located in the backend folder.

3. **Run the Frontend:**
   - In the `front` project directory, run `npm start` to launch the frontend.
   - This will start the app in development mode.
   - Open [http://localhost:3000](http://localhost:3000) in your browser to view it.

4. **Run the Backend:**
   - Navigate to the `backend` folder and run the Spring Boot application.
   - The backend will be running at [http://localhost:8083/](http://localhost:8083/).

#### Additional Notes
- I have added `BROWSER=none` in the environment, so after running `npm start`, you'll need to manually open [http://localhost:3000](http://localhost:3000) in your browser.
