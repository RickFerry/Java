import { Component } from "react";

class Formulario extends Component {

  constructor(){
    super();

    this.nome = '';
    this.validade = '';
    this.preco = '';
  }

  _mudancaInputNome = (event) =>{
    event.stopPropagation();
    this.nome = event.target.value;
  }
  _mudancaInputValidade = (event) =>{
    event.stopPropagation();
    this.validade = event.target.value;
  }
  _mudancaInputPreco = (event) =>{
    event.stopPropagation();
    this.preco = event.target.value;
  }
  _criarHamburguer = (event) =>{
    event.preventDefault();
    event.stopPropagation();
    
    this.props.criarHamburguer(
              this.nome,
              this.validade,
              this.preco
    );
  }

  render() {
    return (
      <form onSubmit={this._criarHamburguer.bind(this)}>
        <div>
          Nome: <input
          type="text"
          onChange={this._mudancaInputNome.bind(this)}/>
        </div>

        <div>
          Validade: <input
          type="date"
          onChange={this._mudancaInputValidade.bind(this)}/>
        </div>

        <div>
          Preço: <input
          type="number"
          onChange={this._mudancaInputPreco.bind(this)}/>
        </div>

        <div>
          <button>Cadastrar</button>
          <button>Pesquisar</button>
        </div>
      </form>
    );
  }
}

export default Formulario;
