let entities = [];

function showCreateEntityForm() {
    document.getElementById('create-entity-form').style.display = 'block';
}

document.getElementById('new-entity-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const entityName = document.getElementById('entity-name').value;
    const entityId = Date.now();

    entities.push({ id: entityId, name: entityName });
    renderEntities();

    document.getElementById('new-entity-form').reset();
    document.getElementById('create-entity-form').style.display = 'none';
});

function renderEntities() {
    const entityListDiv = document.getElementById('entity-list');
    entityListDiv.innerHTML = '';

    entities.forEach(entity => {
        const entityDiv = document.createElement('div');
        entityDiv.innerHTML = `
            <p>${entity.name} 
                <button onclick="editEntity(${entity.id})">Редагувати</button>
                <button onclick="deleteEntity(${entity.id})">Видалити</button>
            </p>
        `;
        entityListDiv.appendChild(entityDiv);
    });
}

function editEntity(id) {
    const entity = entities.find(e => e.id === id);
    const newName = prompt('Редагувати назву сутності:', entity.name);

    if (newName) {
        entity.name = newName;
        renderEntities();
    }
}

function deleteEntity(id) {
    entities = entities.filter(e => e.id !== id);
    renderEntities();
}
