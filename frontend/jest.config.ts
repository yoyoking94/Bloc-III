module.exports = {
    preset: 'jest-preset-angular',
    setupFilesAfterEnv: ['<rootDir>/setup-jest.ts'],
    globals: {
      'ts-jest': {
        tsconfig: '<rootDir>/tsconfig.spec.json',
        stringifyContentPathRegex: '\\.html$',
      }
    },
    testEnvironment: 'jsdom',
    transform: {
      '^.+\\.(ts|js|html)$': 'ts-jest',
    },
    moduleFileExtensions: ['ts', 'html', 'js', 'json'],
    coverageDirectory: '<rootDir>/coverage/',
    collectCoverage: true,
    collectCoverageFrom: [
      'src/app/**/*.ts',
      '!src/app/**/*.module.ts',
      '!src/app/**/*.(spec|mock).ts',
      '!src/environments/**'
    ],
  };
  