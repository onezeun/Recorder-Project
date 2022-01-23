import { css } from 'styled-components';
import styled from 'styled-components';

export const sizes = {
  wide: '1200px',
  desktop: '992px',
  tablet: '768px',
  phone: '376px'
};

export const media = Object.keys(sizes).reduce((acc, label) => {
  acc[label] = (...args) => css`
      @media (max-width: ${sizes[label]}) {
          ${css(...args)}
      }
  `;
  return acc;
}, {});