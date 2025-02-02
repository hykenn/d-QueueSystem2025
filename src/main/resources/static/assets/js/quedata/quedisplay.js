// Fetch data from the API and populate the table and cards
fetch('http://localhost:2025/api/v1/queue/all')
  .then(response => response.json())  // Assuming the API responds with JSON data
  .then(data => {
    const tbody = document.getElementById('queue-data');   // Table body for queue list
    const queueCardContainer = document.getElementById('queue-card');  // Container for the first queue card
    
    tbody.innerHTML = ''; // Clear any existing data in the table
    queueCardContainer.innerHTML = ''; // Clear any existing cards
    
    if (data.length > 0) {
      // Handle the first item (queue number)
      const firstItem = data[0];
      
      // Create a card for the first queue number
      const cardCol = document.createElement('div');
      cardCol.classList.add('col-12', 'col-md-12', 'd-flex', 'justify-content-center', 'align-items-center');
      cardCol.innerHTML = `
        <div class="card h-100 w-100">
          <div class="card-body text-center d-flex flex-column justify-content-center align-items-center">
            <p>OFFICE A</p>
            <p class="card-title" style="font-size: 20rem; font-weight: bold;">${firstItem.qunem}</p> <!-- Display first quenum here -->
            <button class="bx bx-call me-1 btn btn-success mb-2" style="width: 200px;">Call Serve</button>
            <button class="bx bx-trash me-1 btn btn-danger mb-2" style="width: 200px;">End Transaction</button>
          </div>
        </div>
      `;
      queueCardContainer.appendChild(cardCol);  // Append the card to the container

      // Add the first queue number to the waiting list table with a special label
      const firstRow = document.createElement('tr');
      firstRow.classList.add('current-queue');  // Class to mark it as the current queue
      firstRow.innerHTML = `
        <td>${firstItem.qunem} <span class="badge bg-primary">Current Serve</span></td>
        <td>${firstItem.officeto}</td>
        <td><span style="color: black;" class="badge bg-label-${firstItem.priority.toLowerCase().replace(' ', '-')}-priority me-1">${firstItem.priority}</span></td>
        <td>
          <div class="dropdown">
            <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
              <i class="bx bx-dots-vertical-rounded"></i>
            </button>
            <div class="dropdown-menu">
              <a class="dropdown-item" href="#"><i class="bx bx-edit-alt me-1 btn btn-outline-success"> Move Office</i></a>
              <a class="dropdown-item" href="#"><i class="bx bx-trash me-1 btn btn-outline-danger"> End Transaction</i></a>
            </div>
          </div>
        </td>
      `;
      tbody.appendChild(firstRow);  // Append the first row to the table

      // Add the rest of the queue numbers to the table (excluding the first item)
      data.slice(1).forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
          <td>${item.qunem}</td>
          <td>${item.officeto}</td>
          <td><span style="color: black;" class="badge bg-label-${item.priority.toLowerCase().replace(' ', '-')}-priority me-1">${item.priority}</span></td>
          <td>
            <div class="dropdown">
              <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                <i class="bx bx-dots-vertical-rounded"></i>
              </button>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="javascript:void(0);"><i class="bx bx-edit-alt me-1"></i> Edit</a>
                <a class="dropdown-item" href="javascript:void(0);"><i class="bx bx-trash me-1"></i> Delete</a>
              </div>
            </div>
          </td>
        `;
        tbody.appendChild(row);  // Append each row to the table
      });
    }
  })
  .catch(error => {
    console.error('Error fetching data:', error);
  });
