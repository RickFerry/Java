import { Component } from "react";

import Formulario from "./components/formulario";
import Tabela from "./components/tabela";
import service from './services/hamburgueriaService';

class App extends Component {
  constructor() {
    super();

    this.state = {
      hamburguer: [{
        nome: '',
        validade: '',
        preco:''
      }],
    };
  }

  criarHamburguer(nome, validade, preco){
    const hamburguer = {nome, validade, preco};
    service.adiciona(JSON.stringify(hamburguer));
    this.setState({hamburguer: [...this.state.hamburguer, hamburguer]}); 
  }

  render() {
    return (
      <>
        <Formulario criarHamburguer={this.criarHamburguer.bind(this)}/>
        <Tabela hamburguer={this.state.hamburguer}/>
      </>
    );
  }
}

export default App;
