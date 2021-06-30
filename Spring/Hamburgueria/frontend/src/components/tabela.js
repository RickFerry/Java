import { Component } from "react";

class Tabela extends Component {
  render() {
    return (
      <table>
        <thead>
          <tr>
            <th>Nome</th>
            <th>Validade</th>
            <th>Preço</th>
          </tr>
        </thead>
        <tbody>
            {this.props.hamburguer.map((hamburguer, index) => {
              return (
                <tr key={index}>
                  <td>{hamburguer.nome}</td>
                  <td>{hamburguer.validade}</td>
                  <td>{hamburguer.preco}</td>
                </tr>
              );
            })}
        </tbody>
      </table>
    );
  }
}

export default Tabela;
