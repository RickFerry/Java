
const service = {
    listar(){
        fetch('http://localhost:8080/hamburguer/lista')
            .then(res => res.json());
    },
    adiciona:(hamburguer) =>{
        fetch('http://localhost:8080/hamburguer/cadastro', {method: 'post', headers:{'content-type': 'application/json'}, body: hamburguer})
            .then(res => res.json());  
    }
}

export default service;