async function registerUser(event) {
    event.preventDefault();

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return;
    }

    let user = {
        name: name,
        email: email,
        phone: phone,
        password: password
    };

    try {
        let response = await fetch("http://localhost:8080/api/users/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        });

        if (response.ok) {
            alert("Registration successful!");
            window.location.href = "login.html";
        } else {
            alert("Registration failed!");
        }

    } catch (error) {
        alert("Backend is not connected!");
        console.log(error);
    }
}

async function loginUser(event) {
    event.preventDefault();

    let email = document.getElementById("loginEmail").value;
    let password = document.getElementById("loginPassword").value;

    if (email === "" || password === "") {
        alert("Please enter email and password.");
        return;
    }

    let user = {
        email: email,
        password: password
    };

    try {
        let response = await fetch("http://localhost:8080/api/users/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(user)
        });

        let result = await response.text();

        if (result === "Login successful") {
            alert("Login successful!");
            window.location.href = "dashboard.html";
        } else {
            alert("Invalid email or password!");
        }

    } catch (error) {
        alert("Backend is not connected!");
        console.log(error);
    }
}

async function addVehicle() {

    let vehicleNumber =
        document.getElementById("vehicleNumber").value;

    let vehicleModel =
        document.getElementById("vehicleModel").value;

    let vehicleType =
        document.getElementById("vehicleType").value;

    if (vehicleNumber === "" ||
        vehicleModel === "" ||
        vehicleType === "") {

        alert("Please fill all vehicle details.");
        return;
    }

    let vehicle = {
        vehicleNumber: vehicleNumber,
        vehicleModel: vehicleModel,
        vehicleType: vehicleType
    };

    try {

        let response = await fetch(
            "http://localhost:8080/api/vehicles",
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(vehicle)
            }
        );

        if (response.ok) {

            alert("Vehicle added successfully!");

            document.getElementById("vehicleNumber").value = "";
            document.getElementById("vehicleModel").value = "";
            document.getElementById("vehicleType").value = "";

            loadVehicles();

        } else {

            alert("Failed to add vehicle.");

        }

    } catch (error) {

        alert("Backend is not connected!");
        console.log(error);

    }
}
async function loadVehicles() {

    try {

        let response = await fetch(
            "http://localhost:8080/api/vehicles"
        );

        let vehicles = await response.json();

        let container =
            document.getElementById("vehicleContainer");

        container.innerHTML = "";

        vehicles.forEach(vehicle => {

            let card = document.createElement("div");

            card.className = "vehicle-card";

            card.innerHTML = `
                <div class="vehicle-icon">
                    🚗
                </div>

                <div>
                    <h3>${vehicle.vehicleNumber}</h3>

                    <p>
                        Model: ${vehicle.vehicleModel}
                    </p>

                    <p>
                        Type: ${vehicle.vehicleType}
                    </p>
                </div>

                <div class="vehicle-actions">

                    <button
                        class="delete-button"
                        onclick="deleteVehicle(${vehicle.vehicleId})">

                        Delete

                    </button>

                </div>
            `;

            container.appendChild(card);

        });

    } catch (error) {

        console.log(error);

    }
}
async function deleteVehicle(id) {

    try {

        let response = await fetch(
            "http://localhost:8080/api/vehicles/" + id,
            {
                method: "DELETE"
            }
        );

        if (response.ok) {

            alert("Vehicle deleted successfully!");

            loadVehicles();

        } else {

            alert("Failed to delete vehicle.");

        }

    } catch (error) {

        alert("Backend is not connected!");
        console.log(error);

    }
}
async function loadParking() {

    try {

        let response = await fetch(
            "http://localhost:8080/api/parking"
        );

        let parkingList = await response.json();

        let container =
            document.getElementById("parkingContainer");

        container.innerHTML = "";

        parkingList.forEach(parking => {

            let card = document.createElement("div");

            card.className = "parking-card";

            card.innerHTML = `
                <div class="parking-card-icon">
                    🅿️
                </div>

                <h3>${parking.name}</h3>

                <p>
                    📍 ${parking.location}
                </p>

                <p>
                    🟢 <strong>
                    ${parking.availableSlots} slots available
                    </strong>
                </p>

                <p>
                    💰 ₹${parking.pricePerHour} / hour
                </p>
                <button
    class="primary-button"
    onclick="selectParking(${parking.parkingId}, '${parking.name}', '${parking.location}', ${parking.pricePerHour})">
    View Slots
</button>
            `;

            container.appendChild(card);

        });

    } catch (error) {

        console.log(error);

    }
}
loadParking();

function selectParking(id, name, location, price) {

    localStorage.setItem("selectedParkingId", id);
    localStorage.setItem("selectedParkingName", name);
    localStorage.setItem("selectedParkingLocation", location);
    localStorage.setItem("selectedParkingPrice", price);

    localStorage.removeItem("paymentType");
    localStorage.removeItem("extensionHours");
    localStorage.removeItem("extensionFee");
    localStorage.removeItem("newEndTime");

    window.location.href = "slots.html";
}

function searchParking() {

    let search =
        document.getElementById("searchLocation")
        .value
        .toLowerCase();

    let cards =
        document.querySelectorAll(".parking-card");

    cards.forEach(card => {

        let text =
            card.innerText.toLowerCase();

        if (text.includes(search)) {

            card.style.display = "block";

        } else {

            card.style.display = "none";

        }

    });
}