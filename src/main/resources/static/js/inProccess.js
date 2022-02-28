function castShadow() {
    const tractor = document.getElementById('tractor')
    const shadow = tractor.cloneNode(true)
    shadow.id = 'shadow'
    tractor.append(shadow)
}

castShadow()